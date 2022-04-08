package com.example.floodwatch.FLpost;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class FLpostService {
    private final FLpostRepository fLpostRepository;

    @Autowired
    public FLpostService(FLpostRepository fLpostRepository) {
      this.fLpostRepository = fLpostRepository;
    }

    // GET SERVICE
    public List<FLpost> getFLpostFromService(){
      return  fLpostRepository.findAll();
    }

    // POST SERVICE
    public void addFlpostFromService(FLpost fLpost){
      fLpostRepository.save(fLpost);
    }

    // Simple Get by ID
    public FLpost getFileById(Long id) {
      Optional<FLpost> fLpostOptional = fLpostRepository.findById(id);
      if (fLpostOptional.isPresent()) {
        return fLpostOptional.get();
      } return null;
    }

    // GET DATA FILE
  public FLpost getImage(Long id) throws IOException {
      final Optional<FLpost> retrievedImage = fLpostRepository.findById(id);
      FLpost file = new FLpost(retrievedImage.get().getProfName(),
        retrievedImage.get().getProfEmail(), retrievedImage.get().getProfTextPost(),
        retrievedImage.get().getProfPostTime(),
        decompressBytes(retrievedImage.get().getProfFile()));
      return file;
  }
    //POST DATA FILE
//  public FLpost uploadImage(MultipartFile file, FLpost fLpost) throws IOException {
//      String filename = file.getOriginalFilename();
//      FLpost fLfiles = new FLpost(filename, file.getContentType(),
//        compressBytes(file.getBytes()));
//      return fLpostRepository.save(fLfiles, fLpost);
//  }

    // Compressor
    public static byte[] compressBytes(byte[] data) {
      Deflater deflater = new Deflater();
      deflater.setInput(data);
      deflater.setInput(data);
      deflater.finished();
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
      System.out.println("Comprerssed img byte size - " + outputStream.toByteArray().length);
      return outputStream.toByteArray();
    }
    // Decompressor
    public static byte[] decompressBytes(byte[] data) {
      Inflater inflater = new Inflater();
      inflater.setInput(data);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
      byte[] buffer = new byte[1024];
      try {
        while (!inflater.finished()) {
          int count = inflater.inflate(buffer);
          outputStream.write(buffer, 0, count);
        }
        outputStream.close();
      } catch (IOException | DataFormatException e) {
      }
      return outputStream.toByteArray();
    }

    // DELETE SERVICE
    public void deleteFLpost(Long postId) {
      boolean exists =  fLpostRepository.existsById(postId);
      if (!exists) {
        throw new IllegalStateException("Student id does not exist");
      } else {
          fLpostRepository.deleteById(postId);
      }
    }

    // UPDATE SERVICE
     @Transactional
     public void updateFLpost(Long postId, String profTextPost) {
        FLpost fLpost = fLpostRepository.findById(postId)
            .orElseThrow(() -> new IllegalStateException("student does not exists"));
     fLpost.setProfTextPost(profTextPost);
//    if (profTextPost != null &&
//          profTextPost.length() > 0 &&
//          !Objects.equals(fLpost.getProfTextPost(), profTextPost)) {
//        fLpost.setProfTextPost(profTextPost);
//      }
    }




    //for fileeeeeeeeeeeeeeeeeeee START

    //for fileeeeeeeeeeeeeeeeeeee START
}
