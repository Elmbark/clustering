package com.fdev.clustering.host.service;


import com.fdev.clustering.host.dto.HostCreationRequest;
import com.fdev.clustering.host.dto.HostDTO;


public interface HostService {
    HostDTO getHost(String hostId);
    HostDTO createHost(HostCreationRequest host);
}
