package br.com.mercadoLivre.uploader;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface UploaderManager {

    Set<String> envia(List<MultipartFile> images );
}
