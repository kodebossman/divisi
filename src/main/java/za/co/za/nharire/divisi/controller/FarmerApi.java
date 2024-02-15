package za.co.za.nharire.divisi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.za.nharire.divisi.common.ApiConstants;
import za.co.za.nharire.divisi.common.ApiResponse;
import za.co.za.nharire.divisi.common.CrudApi;
import za.co.za.nharire.divisi.common.PaginationResult;
import za.co.za.nharire.divisi.farmer.model.dto.FarmerDTO;
import za.co.za.nharire.divisi.farmer.service.FarmerService;
import za.co.za.nharire.divisi.util.DivisiUtil;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/farmers")
public class FarmerApi implements CrudApi<FarmerDTO> {

    private final FarmerService farmerService;

    @Override
    @PostMapping(value = "/register")
    public ApiResponse<FarmerDTO> create(@RequestBody FarmerDTO farmerDTO) {

        log.info("New Farmer Registration {} ", DivisiUtil.logData(farmerDTO));

        FarmerDTO dtoResponse = farmerService.createFarmer(farmerDTO);

        return new ApiResponse<>(HttpStatus.CREATED.value(),ApiConstants.FARMER_SUCCESS_MESSAGE,dtoResponse);

    }

    @Override
    public ApiResponse<FarmerDTO> update(FarmerDTO farmerDTO) {
        return null;
    }

    @Override
    public ApiResponse<FarmerDTO> delete(FarmerDTO farmerDTO) {
        return null;
    }

    @Override
    public ApiResponse<PaginationResult<FarmerDTO>> findAll(String search, Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public ApiResponse<FarmerDTO> find(Long id) {
        return null;
    }
}
