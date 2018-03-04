package com.db.efolder.api.rest;

import com.db.efolder.domain.DocServiceResponse;
import com.db.efolder.service.EDocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value ="/TFEFRestServices/edocservice")
@Api(tags = "EDoc Service")
public class EDocController {

    @Autowired
    EDocService eDocService;

    @PostMapping(value = "/upload",
            consumes = {"multipart/form-data"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Upload TM excel sheet", notes = "Reads and stores the values from the excel sheet along with content")
    public DocServiceResponse uploadTMSheet(@RequestParam("file") MultipartFile file,@RequestParam("docinfo") String docinfo) {
        return eDocService.uploadTMSheet(file,docinfo);
    }

}
