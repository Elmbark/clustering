package com.fdev.clustering.host.dto;

import com.fdev.clustering.cluster.model.Cluster;
import com.fdev.clustering.host.model.Status;
import lombok.*;


import java.time.LocalDateTime;
import java.util.Map;
@Data
@AllArgsConstructor
@Builder
public class HostDTO {
    private String id ;
    private String hostName;
    private String ipAddress;
    private Status status;
    private String clusterID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Map<String, String> configurations;
}
