package com.example.floodwatch.FLfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class FLfileService {

  @Autowired
  private FLfileRepository fLfileRepository;

  // POST
  public FLfile uploadImage(MultipartFile file) throws IOException {
    String filename = file.getOriginalFilename();
    FLfile flfiles = new FLfile(filename, file.getContentType(), file.getBytes());
    return fLfileRepository.save(flfiles);
  }
  // GET
  public List<FLfile> getImages(){
    return fLfileRepository.findAll();
  }
  // DELETE
  public void deleteFLfile(Long id) {
    boolean exists = fLfileRepository.existsById(id);
    if (!exists) {
      throw new IllegalStateException(("Student id does not exist"));
    } else {
      fLfileRepository.deleteById(id);
    }
  }


  //  Compressor
  public static byte[] compress(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setInput(data);
    deflater.finish();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!deflater.finished()) {
      int count = deflater.deflate(buffer);
      outputStream.write(buffer, 0, count);
    }
    try {
      outputStream.close();
    } catch (IOException e) {
    }
    System.out.println(outputStream.toByteArray().length);
    return outputStream.toByteArray();
  }
  // Decompressor
  public static byte[] decompress(byte[] data) {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    try {
      while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
      }
    } catch (DataFormatException e) {
    }
    return outputStream.toByteArray();
  }
}
