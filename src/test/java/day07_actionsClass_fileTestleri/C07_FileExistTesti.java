package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExistTesti {
    @Test
    public void test01(){
        // Calistigimiz package icerisinde
        // text.txt isimli bir file oldugnu test edin

        String dinamikDosyaYolu=System.getProperty("user.dir")
                                           +"/src/test/java/day07_actionsClass_fileTestleri/text";
        /*
             !!! src/test.. kısmını text dosyasi uzerinde sağ click yapıp
             CopyPath ve Path From Content Root'u seciyoruz
         */
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

    }
}
