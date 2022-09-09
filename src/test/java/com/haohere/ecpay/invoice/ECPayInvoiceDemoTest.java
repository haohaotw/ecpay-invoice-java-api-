package com.haohere.ecpay.invoice;
import com.haohere.ecpay.invoice.util.AES;
import org.junit.Assert;
import org.junit.Test;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * @author haohao
 * @date 2022/4/21
 */
public class ECPayInvoiceDemoTest {

    private final String KEY = "A123456789012345";
    private final String IV = "B123456789012345";

    @Test
    public void encryptDemoTest() {
        var expected = "7woM9RorZKAtXJRVccAb0qhHYm+5lnlhBzyfh5EZdNck7PacNsRHgv/Jvp//ajJidqcQcs0UmAgPQVjXQHeziw==";
        var source = "{\"Name\":\"Test\",\"ID\":\"A123456789\"}";
        var urlEncoder = URLEncoder.encode(source, StandardCharsets.UTF_8);
        var actual = AES.encrypt(urlEncoder, KEY, IV);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decryptDemoTest() {
        var expected = "{\"Name\":\"Test\",\"ID\":\"A123456789\"}";
        var source = "7woM9RorZKAtXJRVccAb0qhHYm+5lnlhBzyfh5EZdNck7PacNsRHgv/Jvp//ajJidqcQcs0UmAgPQVjXQHeziw==";
        var decrypt = AES.decrypt(source, KEY, IV);
        assert decrypt != null;
        var actual = URLDecoder.decode(decrypt, StandardCharsets.UTF_8);
        Assert.assertEquals(expected, actual);
    }


}
