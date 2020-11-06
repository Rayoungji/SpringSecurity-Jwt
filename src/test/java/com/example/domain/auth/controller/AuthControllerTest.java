package com.example.domain.auth.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.config.ApiDocumentUtils.getDocumentRequest;
import static com.example.config.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("회원가입 성공")
    @Test
    public void signInSuccess() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/signIn/{email}/{pwd}/{role}", "testEmail", "testPwd", "USER")
                        .contentType(MediaType.APPLICATION_JSON)
        );
        resultActions.andDo(print())
                .andExpect(status().isCreated())
                .andDo(document("signIn",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("email").description("가입 이메일"),
                                parameterWithName("pwd").description("가입 비밀번호"),
                                parameterWithName("role").description("가입 권한")
                        ),
                        responseFields(
                                fieldWithPath("id").type(Long.class).description("가입된 회원의 id 값"),
                                fieldWithPath("email").type(String.class).description("가입된 회원의 email 값"),
                                fieldWithPath("pwd").type(String.class).description("가입된 회원 정보의 password 값"),
                                fieldWithPath("role").type(String.class).description("가입된 회원 정보")

                        )
                ));
    }
}