package com.rehabilitationml.ml;

import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.ListDataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import java.util.*;

public class MinimalDL4JPipeline {
    public static void main(String[] args) {
        // Sample features and labels
        double[][] features = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0},
            {2.0, 3.0, 4.0}
        };
        double[][] labels = {
            {0.0},
            {1.0},
            {1.0},
            {0.0}
        };
        DataSet dataSet = new DataSet(Nd4j.create(features), Nd4j.create(labels));
        List<DataSet> listDs = dataSet.asList();
        ListDataSetIterator<DataSet> iterator = new ListDataSetIterator<>(listDs, 2); // batch size 2

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .list()
            .layer(new DenseLayer.Builder().nIn(3).nOut(5).activation(Activation.RELU).build())
            .layer(new OutputLayer.Builder(LossFunctions.LossFunction.XENT)
                .activation(Activation.SIGMOID).nIn(5).nOut(1).build())
            .build();
        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        model.fit(iterator, 10); // Train for 10 epochs

        // Predict on a new sample
        double[] testSample = {3.0, 4.0, 5.0};
        double output = model.output(Nd4j.create(testSample)).getDouble(0);
        System.out.println("Prediction: " + output);
    }
}
