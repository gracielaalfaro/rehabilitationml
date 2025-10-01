package com.rehabilitationml.ml;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.rehabilitationml.model.AthleteRehabData;
import com.rehabilitationml.model.PredictionResult;

public class RehabMLPipelineTest {
    @Test
    public void testPipelineWithSampleData() {
        // Create labeled sample data
        List<AthleteRehabData> dataList = new ArrayList<>();
        dataList.add(createSample("A1", 7, 30, true, true)); // severe injury, long rehab, adhered, success
        dataList.add(createSample("A2", 3, 14, false, false)); // mild injury, short rehab, not adhered, fail
        dataList.add(createSample("A3", 5, 21, true, true)); // moderate injury, medium rehab, adhered, success
        dataList.add(createSample("A4", 8, 40, false, false)); // severe injury, long rehab, not adhered, fail
        dataList.add(createSample("A5", 2, 10, true, true)); // mild injury, short rehab, adhered, success

        RehabMLPipeline pipeline = new RehabMLPipeline();
        pipeline.train(dataList);

        // Test prediction on a new sample
        AthleteRehabData testData = createSample("A6", 6, 25, true, false); // moderate-severe, medium rehab, adhered
        PredictionResult result = pipeline.predict(testData);
        assertEquals("A6", result.getAthleteId());
        assertNotNull(result.getConfidenceScore());
        System.out.println("Predicted success: " + result.isPredictedSuccess() + ", confidence: " + result.getConfidenceScore());
    }

    private AthleteRehabData createSample(String id, int severity, int duration, boolean adhered, boolean success) {
        AthleteRehabData data = new AthleteRehabData();
        data.setAthleteId(id);
        data.setInjurySeverity(severity);
        data.setRehabDurationDays(duration);
        data.setProtocolAdherence(adhered);
        data.setRehabSuccess(success);
        return data;
    }
}
