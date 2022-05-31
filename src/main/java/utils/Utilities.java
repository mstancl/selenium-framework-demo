package utils;

public class Utilities {


    public static void sleep(Integer durationInMilis) {
        try {
            Thread.sleep(durationInMilis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static RGBModel parseRGBValuesFromString(String rgbValues) {
        rgbValues = rgbValues.replaceAll("rgb\\(", "").replaceAll("\\)", "").trim();
        return new RGBModel(Integer.parseInt(rgbValues.split(",")[0].trim()), Integer.parseInt(rgbValues.split(",")[1].trim()), Integer.parseInt(rgbValues.split(",")[2].trim()));

    }

}
