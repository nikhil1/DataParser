package com.example.datafileparser;

import com.example.datafileparser.data.repository.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.mock;

public class RepositoryTests {

    public DataRepository dataRepository;


    @BeforeEach
    public void setUp(){
        dataRepository = mock(DataRepository.class);
    }

    @Test
    public void testRepoHasProperties(){
        assertThat("class does not have buffered reader property dataBuffer", dataRepository, hasProperty("dataBuffer"));
        assertThat("class does not have FileOperator property operator", dataRepository, hasProperty("operator"));
        assertThat("class does not have ArrayList<User> property userList", dataRepository, hasProperty("userList"));
    }



}
