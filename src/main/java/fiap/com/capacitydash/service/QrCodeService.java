package fiap.com.capacitydash.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import fiap.com.capacitydash.model.Motorcycle;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class QrCodeService {

    private final HttpServletRequest request;

    public String generateQRCodeMoto(Motorcycle motorcycle){
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            String motoUrl = baseUrl + "/dashboard/moto/" + motorcycle.getPlate();
            BitMatrix bitMatrix = qrCodeWriter.encode(motoUrl, BarcodeFormat.QR_CODE, 200, 200);
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray();

            return Base64.getEncoder().encodeToString(pngData);
        } catch (WriterException | IOException e) {
            throw new RuntimeException("Erro ao gerar o QR Code.", e);
        }

    }
}
