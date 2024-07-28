package com.fdev.clustering.host.service;


import com.fdev.clustering.cluster.model.Cluster;
import com.fdev.clustering.cluster.repository.ClusterRepository;
import com.fdev.clustering.cluster.service.ClusterService;
import com.fdev.clustering.common.exception.ResourceNotFoundException;
import com.fdev.clustering.host.dto.HostCreationRequest;
import com.fdev.clustering.host.dto.HostDTO;
import com.fdev.clustering.host.model.Host;
import com.fdev.clustering.host.model.Status;
import com.fdev.clustering.host.repository.HostRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;

import java.time.LocalDateTime;

public class HostServiceImpl implements HostService{


    private HostRepository hostRepository;
    private ClusterRepository clusterRepository;

    @Override
    public HostDTO getHost(String hostId){
        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
        return ConvertToDTO(host);
    }

    @Override
    @Transactional
    public HostDTO createHost(HostCreationRequest request) {
        Cluster cluster = clusterRepository.findById(request.getClusterId())
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "id", request.getClusterId()));

        Host host = new Host();
        host.setHostName(request.getHostname());
        host.setIpAddress(request.getIpAddress());
        host.setStatus(Status.valueOf("STOPPED"));
        host.setCreatedAt(LocalDateTime.now());
        host.setUpdatedAt(LocalDateTime.now());
        host.setConfigurations(request.getConfiguration());
        cluster.addHost(host);
        Host savedHost = hostRepository.save(host);
        return ConvertToDTO(savedHost);
    }
    private HostDTO ConvertToDTO(Host host){
        return new HostDTO(
                host.getId(),
                host.getHostName(),
                host.getIpAddress(),
                host.getStatus(),
                host.getCluster().getId(),
                host.getCreatedAt(),
                host.getUpdatedAt(),
                host.getConfigurations()
        );
    }

}
