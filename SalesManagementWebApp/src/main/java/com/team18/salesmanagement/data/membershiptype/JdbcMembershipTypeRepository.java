// File: JdbcMembershipTypeRepository.java
// Data access operations for MembershipType using JDBC
package com.team18.salesmanagement.data.membershiptype;

import com.team18.salesmanagement.domain.membershiptype.MembershipType;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcMembershipTypeRepository implements IMembershipTypeRepository {
    private final JdbcOperations jdbcOperations;
    
    @Autowired
    public JdbcMembershipTypeRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    @Override
    public List<MembershipType> getList() {
        final String GET_MEMBERSHIP_TYPE_LIST =
                "SELECT * FROM membership_types;";
        
        return jdbcOperations.query(GET_MEMBERSHIP_TYPE_LIST,
                (rs, rowNum) -> {
                    return new MembershipType(
                            rs.getInt("id"),
                            rs.getString("membership_type"),
                            rs.getBigDecimal("debt_limit"),
                            rs.getBigDecimal("discount_value"),
                            rs.getString("discount_unit"),
                            ((Date)rs.getObject("valid_from")).toLocalDate(),
                            ((Date)rs.getObject("valid_until")).toLocalDate()
                    );
                });
    } // end method getList
} // end class JdbcMembershipTypeRepository
