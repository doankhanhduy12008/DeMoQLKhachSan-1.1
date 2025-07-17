package Util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class XIcon {
    /**
     * Đọc icon từ resource hoặc file.
     * Nếu path bắt đầu bằng '/' => load từ resource (classpath).
     * Ngược lại => coi là file ngoài.
     */
    public static ImageIcon getIcon(String path) {
        if (path.startsWith("/")) { // Resource trong classpath
            java.net.URL url = XIcon.class.getResource(path);
            if (url != null) {
                return new ImageIcon(url);
            } else {
                System.err.println("Không tìm thấy resource: " + path);
                return null;
            }
        } else { // File ngoài
            return new ImageIcon(path);
        }
    }

    /**
     * Đọc icon theo kích thước
     * @param path đường dẫn file hoặc tài nguyên
     * @param width chiều rộng
     * @param height chiều cao
     * @return Icon
     */
public static ImageIcon getIcon(String path, int width, int height) {
        ImageIcon icon = getIcon(path);

        if (icon == null || icon.getIconWidth() <= 0 || icon.getIconHeight() <= 0) {
//            System.err.println("Ảnh không tồn tại hoặc kích thước không hợp lệ: " + path);
            return null; // hoặc trả về ảnh mặc định
        }

        if (width <= 0 || height <= 0) {
//            System.err.println("Chiều rộng hoặc chiều cao không hợp lệ: " + width + "x" + height);
            return icon; // Trả về icon gốc nếu không resize được
        }

        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    
    
    /**
     * Thay đổi icon của JLabel
     * @param label JLabel cần thay đổi
     * @param path đường dẫn file hoặc tài nguyên
     */
    
    
    
    public static void setIcon(JLabel label, String path) {
        // Resize ảnh với kích thước mặc định nếu label chưa có size
        int width = label.getWidth() > 0 ? label.getWidth() : 80;
        int height = label.getHeight() > 0 ? label.getHeight() : 80;
        label.setIcon(XIcon.getIcon(path, width, height));
    }

    /**
     * Thay đổi icon của JLabel
     * @param label JLabel cần thay đổi
     * @param file file icon
     */
    public static void setIcon(JLabel label, File file) {
        XIcon.setIcon(label, file.getAbsolutePath());
    }
    /**
     * Sao chép file vào thư mục với tên file mới là duy nhất
     * @param fromFile file cần sao chép
     * @param folder thư mục đích
     * @return File đã sao chép
     */
    public static File copyTo(File fromFile, String folder) {
        String fileExt = fromFile.getName().substring(fromFile.getName().lastIndexOf("."));
        File toFile = new File(folder, XStr.getKey() + fileExt);
        toFile.getParentFile().mkdirs();
        try {
            Files.copy(fromFile.toPath(), toFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return toFile;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static File copyTo(File fromFile) {
        return copyTo(fromFile, "files");
    }
}
