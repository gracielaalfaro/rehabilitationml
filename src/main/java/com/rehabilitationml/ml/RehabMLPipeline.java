package com.rehabilitationml.ml;

import com.rehabilitationml.model.AthleteRehabData;
import com.rehabilitationml.model.PredictionResult;
import org.nd4j.linalg.dataset.ListDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import java.util.List;
import java.util.ArrayList;

/**
 * Machine learning pipeline for rehabilitation outcome prediction.
 */
public class RehabMLPipeline {
    private MultiLayerNetwork model;

    /**
     * Preprocesses data and trains a simple neural network model.
     */
    public void train(List<AthleteRehabData> dataList) {
        // Example: Convert AthleteRehabData to feature and label arrays
        List<double[]> features = new ArrayList<>();
        List<Double> labels = new ArrayList<>();
        for (AthleteRehabData data : dataList) {
            // Feature engineering: select relevant features
            double[] feature = new double[] {
                data.getInjurySeverity(),
                data.getRehabDurationDays(),
                data.isProtocolAdherence() ? 1.0 : 0.0
                // Add more features as needed
            };
            features.add(feature);
            labels.add(data.isRehabSuccess() ? 1.0 : 0.0);
        }
        DataSet trainingData = new DataSet(
            Nd4j.create(features.toArray(new double[0][0])),
            Nd4j.create(labels.stream().mapToDouble(Double::doubleValue).toArray(), new long[]{labels.size(), 1})
        );
        ListDataSetIterator<DataSet> iterator = new ListDataSetIterator<>(trainingData.asList(), 16);

        // Build a simple neural network
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .list()
            .layer(new DenseLayer.Builder().nIn(3).nOut(8).activation(Activation.RELU).build())
            .layer(new OutputLayer.Builder(LossFunctions.LossFunction.XENT)
                .activation(Activation.SIGMOID).nIn(8).nOut(1).build())
            .build();
        model = new MultiLayerNetwork(conf);
        model.init();
        model.fit(iterator, 10); // Train for 10 epochs
    }

    /**
     * Predicts rehabilitation success for a new athlete data point.
     */
    public PredictionResult predict(AthleteRehabData data) {
        double[] feature = new double[] {
            data.getInjurySeverity(),
            data.getRehabDurationDays(),
            data.isProtocolAdherence() ? 1.0 : 0.0
            // Add more features as needed
        };
        double output = model.output(Nd4j.create(feature)).getDouble(0);
        PredictionResult result = new PredictionResult();
        result.setAthleteId(data.getAthleteId());
        result.setPredictedSuccess(output > 0.5);
        result.setConfidenceScore(output);
        result.setExplanation("Prediction based on injury severity, rehab duration, and protocol adherence.");
        return result;
    }
}
