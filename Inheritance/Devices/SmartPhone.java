package Inheritance.Devices;

public class SmartPhone implements Camera, MusicPlayer {

    @Override
    public void capturePhoto() {
        System.out.println("Capturing photo, smile please!");
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording video, see here!");
    }

    @Override
    public void startPlayer() {
        System.out.println("Music player started!");
    }

    @Override
    public void stopPlayer() {
        System.out.println("Music player stopped!");
    }
}
