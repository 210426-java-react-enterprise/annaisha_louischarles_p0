package com.revature.BankApp.util;

import com.revature.intro.util.ConnectionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {
    @Test
    public void test_getConnectionWithValidCredentials() {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//            Assert.assertNotNull(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
