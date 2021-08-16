import be.encelade.ouistiti.CameraManager;
import be.encelade.ouistiti.DefaultCameraSpeedCalculator;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

import static be.encelade.ouistiti.ViewMode.ISOMETRIC_VIEW;
import static com.jme3.material.Materials.UNSHADED;

public class TestCameraManagerJava {

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("ouistiti Java Demo");
        settings.setFullscreen(false);
        settings.setVSync(false);
        settings.setSamples(16);
        settings.setResolution(1280, 720);

        DemoApp app = new DemoApp();
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    public static class DemoApp extends SimpleApplication {

        int sizeX = 10;
        int sizeY = 8;
        CameraManager cameraManager;

        @Override
        public void simpleInitApp() {
            cameraManager = new CameraManager(this, ISOMETRIC_VIEW, new DefaultCameraSpeedCalculator());
            cameraManager.addDefaultKeyMappings();

            addFloor();
            viewPort.setBackgroundColor(new ColorRGBA(28 / 255f, 48 / 255f, 100 / 255f, 1f));
        }

        @Override
        public void simpleUpdate(float tpf) {
            cameraManager.simpleUpdate(tpf);
        }

        public void addFloor() {
            Material floorMat = new Material(assetManager, UNSHADED);
            floorMat.setColor("Color", new ColorRGBA(155 / 255f, 164 / 255f, 193 / 255f, 1f));

            Geometry floor = new Geometry("FLOOR", new Box(sizeX / 2f, sizeY / 2f, 0f));
            floor.setMaterial(floorMat);
            rootNode.attachChild(floor);
        }
    }

}
