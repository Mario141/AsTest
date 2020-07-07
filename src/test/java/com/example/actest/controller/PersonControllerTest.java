package com.example.actest.controller;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void getAllPersons() throws Exception {
        String expected = "[{\"id\":1,\"name\":\" Hans\",\"lastname\":\"Müller\",\"zipcode\":\"67742\",\"city\":\"Lauterecken\",\"color\":\"blau\"},{\"id\":2,\"name\":\" Peter\",\"lastname\":\"Petersen\",\"zipcode\":\"18439\",\"city\":\"Stralsund\",\"color\":\"grün\"},{\"id\":3,\"name\":\" Johnny\",\"lastname\":\"Johnson\",\"zipcode\":\"88888\",\"city\":\"madeup\",\"color\":\"violett\"},{\"id\":4,\"name\":\" Milly\",\"lastname\":\"Millenium\",\"zipcode\":\"77777\",\"city\":\"madeuptoo\",\"color\":\"rot\"},{\"id\":5,\"name\":\" Jonas\",\"lastname\":\"Müller\",\"zipcode\":\"32323\",\"city\":\"Hansstadt\",\"color\":\"gelb\"},{\"id\":6,\"name\":\" Tastatur\",\"lastname\":\"Fujitsu\",\"zipcode\":\"42342\",\"city\":\"Japan\",\"color\":\"türkis\"},{\"id\":7,\"name\":\" Anders\",\"lastname\":\"Andersson\",\"zipcode\":\"32132\",\"city\":\"Schweden\",\"color\":\"grün\"},{\"id\":8,\"name\":\" Bertram\",\"lastname\":\"Bart\",\"zipcode\":\"12313\",\"city\":\"Wasweiich\",\"color\":\"blau\"},{\"id\":9,\"name\":\" Gerda\",\"lastname\":\"Gerber\",\"zipcode\":\"76535\",\"city\":\"Woanders\",\"color\":\"violett\"},{\"id\":10,\"name\":\" Klaus\",\"lastname\":\"Klaussen\",\"zipcode\":\"43246\",\"city\":\"Hierach\",\"color\":\"grün\"}]";
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons"))
                .andReturn().getResponse();

        response.setCharacterEncoding("UTF-8");

        JSONAssert.assertEquals(expected, response.getContentAsString(),false);
    }

    @Test
    void getPersonById() throws Exception{

        String expected1 = "{\"id\":1,\"name\":\" Hans\",\"lastname\":\"Müller\",\"zipcode\":\"67742\",\"city\":\"Lauterecken\",\"color\":\"blau\"}";
        String expected2 = "{\"id\":2,\"name\":\" Peter\",\"lastname\":\"Petersen\",\"zipcode\":\"18439\",\"city\":\"Stralsund\",\"color\":\"grün\"}";
        String expected3 = "{\"id\":3,\"name\":\" Johnny\",\"lastname\":\"Johnson\",\"zipcode\":\"88888\",\"city\":\"madeup\",\"color\":\"violett\"}";
        String expected4 = "{\"id\":4,\"name\":\" Milly\",\"lastname\":\"Millenium\",\"zipcode\":\"77777\",\"city\":\"madeuptoo\",\"color\":\"rot\"}";
        String expected5 = "{\"id\":5,\"name\":\" Jonas\",\"lastname\":\"Müller\",\"zipcode\":\"32323\",\"city\":\"Hansstadt\",\"color\":\"gelb\"}";
        String expected6 = "{\"id\":6,\"name\":\" Tastatur\",\"lastname\":\"Fujitsu\",\"zipcode\":\"42342\",\"city\":\"Japan\",\"color\":\"türkis\"}";
        String expected7 = "{\"id\":7,\"name\":\" Anders\",\"lastname\":\"Andersson\",\"zipcode\":\"32132\",\"city\":\"Schweden\",\"color\":\"grün\"}";
        String expected8 = "{\"id\":8,\"name\":\" Bertram\",\"lastname\":\"Bart\",\"zipcode\":\"12313\",\"city\":\"Wasweiich\",\"color\":\"blau\"}";
        String expected9 = "{\"id\":9,\"name\":\" Gerda\",\"lastname\":\"Gerber\",\"zipcode\":\"76535\",\"city\":\"Woanders\",\"color\":\"violett\"}";
        String expected10 = "{\"id\":10,\"name\":\" Klaus\",\"lastname\":\"Klaussen\",\"zipcode\":\"43246\",\"city\":\"Hierach\",\"color\":\"grün\"}";

        for (int id=1;id<11;id++) {
            mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+id))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }

        MockHttpServletResponse response1 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+1))
                    .andReturn().getResponse();
        response1.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response2 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+2))
                .andReturn().getResponse();
        response2.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response3 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+3))
                .andReturn().getResponse();
        response3.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response4 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+4))
                .andReturn().getResponse();
        response4.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response5 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+5))
                .andReturn().getResponse();
        response5.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response6 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+6))
                .andReturn().getResponse();
        response6.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response7 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+7))
                .andReturn().getResponse();
        response7.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response8 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+8))
                .andReturn().getResponse();
        response8.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response9 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+9))
                .andReturn().getResponse();
        response9.setCharacterEncoding("UTF-8");

        MockHttpServletResponse response10 = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/"+10))
                .andReturn().getResponse();
        response10.setCharacterEncoding("UTF-8");

        JSONAssert.assertEquals(expected1, response1.getContentAsString(), false);
        JSONAssert.assertEquals(expected2, response2.getContentAsString(), false);
        JSONAssert.assertEquals(expected3, response3.getContentAsString(), false);
        JSONAssert.assertEquals(expected4, response4.getContentAsString(), false);
        JSONAssert.assertEquals(expected5, response5.getContentAsString(), false);
        JSONAssert.assertEquals(expected6, response6.getContentAsString(), false);
        JSONAssert.assertEquals(expected7, response7.getContentAsString(), false);
        JSONAssert.assertEquals(expected8, response8.getContentAsString(), false);
        JSONAssert.assertEquals(expected9, response9.getContentAsString(), false);
        JSONAssert.assertEquals(expected10, response10.getContentAsString(), false);
    }

    @Test
    void getPersonsByColor() throws Exception{

        String expectedBlau = "[{\"id\":1,\"name\":\" Hans\",\"lastname\":\"Müller\",\"zipcode\":\"67742\",\"city\":\"Lauterecken\",\"color\":\"blau\"},{\"id\":8,\"name\":\" Bertram\",\"lastname\":\"Bart\",\"zipcode\":\"12313\",\"city\":\"Wasweiich\",\"color\":\"blau\"}]";
        String expectedGrün = "[{\"id\":2,\"name\":\" Peter\",\"lastname\":\"Petersen\",\"zipcode\":\"18439\",\"city\":\"Stralsund\",\"color\":\"grün\"},{\"id\":7,\"name\":\" Anders\",\"lastname\":\"Andersson\",\"zipcode\":\"32132\",\"city\":\"Schweden\",\"color\":\"grün\"},{\"id\":10,\"name\":\" Klaus\",\"lastname\":\"Klaussen\",\"zipcode\":\"43246\",\"city\":\"Hierach\",\"color\":\"grün\"}]";
        String expectedViolett = "[{\"id\":3,\"name\":\" Johnny\",\"lastname\":\"Johnson\",\"zipcode\":\"88888\",\"city\":\"madeup\",\"color\":\"violett\"},{\"id\":9,\"name\":\" Gerda\",\"lastname\":\"Gerber\",\"zipcode\":\"76535\",\"city\":\"Woanders\",\"color\":\"violett\"}]";
        String expectedRot = "[{\"id\":4,\"name\":\" Milly\",\"lastname\":\"Millenium\",\"zipcode\":\"77777\",\"city\":\"madeuptoo\",\"color\":\"rot\"}]";
        String expectedGelb = "[{\"id\":5,\"name\":\" Jonas\",\"lastname\":\"Müller\",\"zipcode\":\"32323\",\"city\":\"Hansstadt\",\"color\":\"gelb\"}]";
        String expectedTürkis = "[{\"id\":6,\"name\":\" Tastatur\",\"lastname\":\"Fujitsu\",\"zipcode\":\"42342\",\"city\":\"Japan\",\"color\":\"türkis\"}]";
        String expectedWeiß = "[]";

        String color;

        for (int i=1; i<8; i++) {
            if (i == 1) {
                color = "blau";
            }else if (i == 2){
                color = "grün";
            }else if (i == 3) {
                color = "violett";
            }else if (i == 4) {
                color = "rot";
            }else if (i == 5){
                color = "gelb";
            }else if (i == 6) {
                color = "türkis";
            }else {
                color = "weiß";
            }
            mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/"+color))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }

        MockHttpServletResponse responseBlau = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/blau"))
                .andReturn().getResponse();
        responseBlau.setCharacterEncoding("UTF-8");

        MockHttpServletResponse responseGrün = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/grün"))
                .andReturn().getResponse();
        responseGrün.setCharacterEncoding("UTF-8");

        MockHttpServletResponse responseViolett = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/violett"))
                .andReturn().getResponse();
        responseViolett.setCharacterEncoding("UTF-8");

        MockHttpServletResponse responseRot = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/rot"))
                .andReturn().getResponse();
        responseRot.setCharacterEncoding("UTF-8");

        MockHttpServletResponse responseGelb = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/gelb"))
                .andReturn().getResponse();
        responseGelb.setCharacterEncoding("UTF-8");

        MockHttpServletResponse responseTürkis = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/türkis"))
                .andReturn().getResponse();
        responseTürkis.setCharacterEncoding("UTF-8");

        MockHttpServletResponse responseWeiß = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/persons/color/weiß"))
                .andReturn().getResponse();
        responseWeiß.setCharacterEncoding("UTF-8");

        JSONAssert.assertEquals(expectedBlau, responseBlau.getContentAsString(), false);
        JSONAssert.assertEquals(expectedGelb, responseGelb.getContentAsString(), false);
        JSONAssert.assertEquals(expectedGrün, responseGrün.getContentAsString(), false);
        JSONAssert.assertEquals(expectedRot, responseRot.getContentAsString(), false);
        JSONAssert.assertEquals(expectedTürkis, responseTürkis.getContentAsString(), false);
        JSONAssert.assertEquals(expectedViolett, responseViolett.getContentAsString(), false);
        JSONAssert.assertEquals(expectedWeiß, responseWeiß.getContentAsString(), false);
    }
}