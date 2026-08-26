package com.example.datafileparser;

import com.example.datafileparser.data.model.User;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.mock;

public class ModelTests {

    @Test
    public void testModelPropertiesExist(){
        User testUser = mock(User.class);

        assertThat("id property does not exist", testUser,  hasProperty("id"));
        assertThat("first_name property does not exist", testUser,  hasProperty("first_name"));
        assertThat("last_name property does not exist", testUser,  hasProperty("last_name"));
        assertThat("email property does not exist", testUser,  hasProperty("email"));
        assertThat("gender property does not exist", testUser,  hasProperty("gender"));
        assertThat("phone property does not exist", testUser,  hasProperty("phone"));
    }

}
