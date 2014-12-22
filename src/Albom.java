import java.util.*;
import java.math.*;

public abstract class Albom {
    String name;
    String CD;
    String text;
    public String getName() {
        return name;
    }
    public void prepare() {
        System.out.println("Издаем альбом версии " + name);
        System.out.println("Записываем " + CD);
        System.out.println("Записываем " + text);
    }
    public void add() {
        System.out.println("Изготавливаем карточки участников группы");
    }
}


class StyleSpecAlbom extends Albom {
    public StyleSpecAlbom() {
        name = "'Специальное издание'";
        CD = "CD диск";
        text = "Тексты песен";
    }
     @Override
    public void add() {
        System.out.println("Записываем DVD c музыкальным видео и видео со съемок");
        System.out.println("Издаем фотобук");
        System.out.println("Делаем общий плакат группы с автографами участников");
    }
}


abstract class AlbomStore {
    public Albom orderAlbom () {
        Albom albom;
        albom = createAlbom();
        albom.prepare();
        albom.add();
        return albom;
    }
    protected abstract Albom createAlbom ();
}


class SpecAlbomStore extends AlbomStore{
    @Override
    protected Albom createAlbom() {
            return new StyleSpecAlbom();
    }
}

class StyleOrigAlbom extends Albom {

    public StyleOrigAlbom() {
        name = "'Оригинальное издание'";
        CD = "CD диск";
        text = "Тексты песен";
    } 
}

class OrigAlbomStore extends AlbomStore{
    @Override
    protected Albom createAlbom() {
        return new StyleOrigAlbom();
    }
}

class AlbomTestDrive {

    public static void main(String[] args) {
        OrderNumber Orignumber = new OrderNumber();
        OrderNumber Specnumber = new OrderNumber();
        System.out.println("Выпуска альбома верии 'Специальное издание' планируется "+Specnumber.rand1+"."+Specnumber.rand2+"."+Specnumber.rand3+" г.");
        AlbomStore SpecStore = new SpecAlbomStore();
        Albom albom = SpecStore.orderAlbom();
        System.out.println();
        System.out.println("Выпуска альбома верии 'Оригинальное издание' планируется "+Orignumber.rand1+"."+Orignumber.rand2+"."+Orignumber.rand3+" г.");
        AlbomStore OrigStore = new OrigAlbomStore();
        albom = OrigStore.orderAlbom();
    }
}

class OrderNumber {
    int rand1 = (int) (Math.random()*31 + 1); 
    int rand2 = (int) (Math.random()*12 + 1); 
    int rand3 = (int) (Math.random()*1 + 2015); 
}


