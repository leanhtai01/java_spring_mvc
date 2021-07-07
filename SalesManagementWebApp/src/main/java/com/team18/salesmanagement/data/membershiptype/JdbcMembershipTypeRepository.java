// File: JdbcMembershipTypeRepository.java
// Data access operations for MembershipType using JDBC
package com.team18.salesmanagement.data.membershiptype;

import com.team18.salesmanagement.domain.membershiptype.MembershipType;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcMembershipTypeRepository implements IMembershipTypeRepository {
    private final JdbcOperations jdbcOperations;
    private final SimpleJdbcCall simpleJdbcCall;
    
    @Autowired
    public JdbcMembershipTypeRepository(JdbcOperations jdbcOperations,
            SimpleJdbcCall simpleJdbcCall) {
        this.jdbcOperations = jdbcOperations;
        this.simpleJdbcCall = simpleJdbcCall;
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
    
    // get discount value by given membership type id
    @Override
    public BigDecimal getDiscountValue(int id) {
        final String GET_MEMBERSHIP_TYPE = "SELECT * FROM membership_types"
                + " WHERE id = ?;";
        
        MembershipType membershipType = jdbcOperations
                .queryForObject(GET_MEMBERSHIP_TYPE,
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
                }, id);
        
        return membershipType.isValid() ? membershipType.getDiscountValue() : BigDecimal.ZERO;
    }
    
    // get discount unit by given membership type id
    @Override
    public String getDiscountUnit(int id) {
        final String GET_MEMBERSHIP_TYPE = "SELECT * FROM membership_types"
                + " WHERE id = ?;";
        
        MembershipType membershipType = jdbcOperations
                .queryForObject(GET_MEMBERSHIP_TYPE,
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
                }, id);
        
        return membershipType.getDiscountUnit();
    }
    
    // get debt limit by given membership type id
    @Override
    public BigDecimal getDebtLimit(Integer id) {
        final String GET_MEMBERSHIP_TYPE = "SELECT * FROM membership_types"
                + " WHERE id = ?;";
        
        MembershipType membershipType = jdbcOperations
                .queryForObject(GET_MEMBERSHIP_TYPE,
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
                }, id);
        
        return membershipType.getDebtLimit();
    }
    
    // insert a new membership type
    @Override
    public Integer insert(MembershipType membershipType) {
        Map<String, Object> params = new HashMap<>();
        Integer membershipTypeId = -1;
        Integer errorCode = 0;
        
        params.put("param_membership_type", membershipType.getMembershipType());
        params.put("param_debt_limit", membershipType.getDebtLimit());
        params.put("param_discount_value", membershipType.getDiscountValue());
        params.put("param_discount_unit", membershipType.getDiscountUnit());
        params.put("param_valid_from", membershipType.getValidFrom());
        params.put("param_valid_until", membershipType.getValidUntil());
        params.put("membership_type_id", membershipTypeId);
        params.put("error_code", errorCode);
        
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("insert_membership_type")
                .execute(params);
        errorCode = (Integer) result.get("error_code");
        
        if (errorCode == 1) {
            throw new DuplicateMembershipTypeException();
        }
        
        return (Integer) result.get("membership_type_id");
    }
    
    // update a membership type
    @Override
    public void update(MembershipType membershipType) {
        Map<String, Object> params = new HashMap<>();
        Integer errorCode = 0;
        
        params.put("param_id", membershipType.getId());
        params.put("param_membership_type", membershipType.getMembershipType());
        params.put("param_debt_limit", membershipType.getDebtLimit());
        params.put("param_discount_value", membershipType.getDiscountValue());
        params.put("param_discount_unit", membershipType.getDiscountUnit());
        params.put("param_valid_from", membershipType.getValidFrom());
        params.put("param_valid_until", membershipType.getValidUntil());
        params.put("error_code", errorCode);
        
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("update_membership_type")
                .execute(params);
        errorCode = (Integer) result.get("error_code");
        
        switch (errorCode) {
            case 1:
                throw new DuplicateMembershipTypeException();
            case 3:
                throw new NotExistMembershipTypeException();
            default:
                break;
        }
    }
    
    // get Membership Type by id
    @Override
    public MembershipType getMembershipType(int id) {
        final String GET_MEMBERSHIP_TYPE = "SELECT * "
                + "FROM membership_types "
                + "WHERE id = ?;";
        return jdbcOperations.queryForObject(GET_MEMBERSHIP_TYPE,
                (rs, rowNum) -> {
                    return new MembershipType(
                            rs.getInt("id"),
                            rs.getString("membership_type"),
                            rs.getBigDecimal("debt_limit"),
                            rs.getBigDecimal("discount_value"),
                            rs.getString("discount_unit"),
                            ((Date) rs.getObject("valid_from")).toLocalDate(),
                            ((Date) rs.getObject("valid_until")).toLocalDate()
                    );
                }, id);
    }
} // end class JdbcMembershipTypeRepository
