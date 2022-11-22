package org.remijn.streamproxy.controller;

import org.remijn.streamproxy.service.VideoStreamingService;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VideoStreamController {

    VideoStreamingService videoStreamingService;

    public VideoStreamController(VideoStreamingService videoStreamingService) {
        this.videoStreamingService = videoStreamingService;
    }

    @GetMapping(value = "/video/{titleName}" , produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String titleName) {
        return videoStreamingService.getVideoStreaming(titleName);
    }

}
