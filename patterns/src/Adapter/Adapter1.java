package Adapter;

public class Adapter1 { //способ через наследование
    public static void main(String[] args) {
        //способ через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
        //способ через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g2.drawSquare();
        g2.drawLine();
        
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}
class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare(){
        System.out.println("Рисуем квадрат");
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    public void drawLine() {
        drawRasterLine();
    }
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface { //тут мы вызываем медоты через объект

   RasterGraphics rasterGraphics = new RasterGraphics();

    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics) {
        this.rasterGraphics = rasterGraphics;
    }
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
