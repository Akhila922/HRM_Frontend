package com.cg.hrms.service;

import com.cg.hrms.dto.RegionDto;
import java.util.List;

public interface RegionServiceVighnesh {
  List<RegionDto> getAllRegions();
  RegionDto getRegionById(Long id);
}
