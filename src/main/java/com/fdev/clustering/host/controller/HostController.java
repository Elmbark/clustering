package com.fdev.clustering.host.controller;


import com.fdev.clustering.host.dto.HostCreationRequest;
import com.fdev.clustering.host.dto.HostDTO;
import com.fdev.clustering.host.model.Host;
import com.fdev.clustering.host.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/host")
@RequiredArgsConstructor
public class HostController {

    private  HostService hostService;

    @PostMapping("/{host}")
    public ResponseEntity<HostDTO> createHost(@PathVariable HostCreationRequest hostCreationRequest){
        HostDTO host = hostService.createHost(hostCreationRequest);
        return new ResponseEntity<>(host, HttpStatus.CREATED);
    }

    @GetMapping("/{hostId}")
    public ResponseEntity<HostDTO> getHost(@PathVariable String hostId){
        HostDTO host = hostService.getHost(hostId);
        return ResponseEntity.ok(host);
    }


}
