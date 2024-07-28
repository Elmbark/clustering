package com.fdev.clustering.host.dto;

import lombok.*;
import java.util.Map;


@Data
@AllArgsConstructor
@Builder
public class HostCreationRequest {
    private String hostname;
    private String ipAddress;
    private String clusterId;
    private Map<String,String> configuration;

}
