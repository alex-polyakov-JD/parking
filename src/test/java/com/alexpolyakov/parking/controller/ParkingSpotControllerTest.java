package com.alexpolyakov.parking.controller;

import com.alexpolyakov.parking.service.ParkingSpotService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@WebMvcTest(ParkingSpotController.class)
class ParkingSpotControllerTest {

    @MockBean
    private ParkingSpotService service;

    @Autowired
    private ParkingSpotController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCountVacantShouldReturnCorrectJson() throws Exception {
        when(service.findVacant()).thenReturn(5L);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/spots/count/vacant")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "5";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

        verify(service).findVacant();
        verifyNoMoreInteractions(service);
    }

}
