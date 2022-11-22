package org.remijn.streamproxy.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VideoStreamingService {
    private ResourceLoader resourceLoader;

    public VideoStreamingService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Mono<Resource> getVideoStreaming(String titleName) {
        return Mono.fromSupplier(() -> resourceLoader.getResource("classpath:videos/" + titleName + ".mp4"));
    }


}
