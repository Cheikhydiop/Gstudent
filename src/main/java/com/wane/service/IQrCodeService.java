// QRCodeService.java
package com.wane.service;

import java.io.IOException;

public interface IQrCodeService {
    byte[] generateQRCode(String text) throws IOException;
}