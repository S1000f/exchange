package cointwo.domain.account;

import cointwo.web.dto.AccountDto;
import cointwo.web.dto.MemberDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class AccountDao {

    private JdbcTemplate jdbcTemplate;

    public AccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<AccountDto> memRowMapper = new RowMapper<AccountDto>() {
        @Override
        public AccountDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            AccountDto accountDto = AccountDto.builder()
                    .uid(rs.getLong("UID"))
                    .tender(rs.getInt("TENDER"))
                    .status(rs.getString("STATUS"))
                    .build();
            accountDto.setAid(rs.getLong("AID"));

            return accountDto;
        }
    };

    public AccountDto selectById(String id) {
        List<AccountDto> result = jdbcTemplate.query(
                "select * from MEMBER where ID = ?",
                memRowMapper, id);

        return result.isEmpty() ? null : result.get(0);
    }

    public List<AccountDto> selectByRegdate(LocalDateTime from, LocalDateTime to) {
        List<AccountDto> results = jdbcTemplate.query(
                "select * from MEMBER where REGDATE between ? and ? order by REGDATE desc",
                memRowMapper, from, to);

        return results;
    }

    public List<AccountDto> selectAll() {
        return jdbcTemplate.query(
                "select * from MEMBER",
                memRowMapper);
    }

    public AccountDto selectByUid(Long uid) {
        List<AccountDto> results = jdbcTemplate.query(
                "select * from ACCOUNT where UID = ?",
                memRowMapper, uid);

        return results.isEmpty() ? null : results.get(0);
    }

    public void createAccount(AccountDto accountDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection conn)-> {
                    PreparedStatement pstmt = conn.prepareStatement(
                            "insert into ACCOUNT(UID, TENDER, STATUS, BTC, ETH) values(?,?,?,?,?)",
                            new String[] {"AID"}
                    );
                    pstmt.setLong(1, accountDto.getUid());
                    pstmt.setInt(2, accountDto.getTender());
                    pstmt.setString(3, accountDto.getStatus());
                    pstmt.setDouble(4, accountDto.getBtc());
                    pstmt.setDouble(5, accountDto.getEth());

                    return pstmt;
                }, keyHolder
        );
        Number keyValue = keyHolder.getKey();
        accountDto.setAid(keyValue.longValue());
    }

    public void update(MemberDto member) {
        jdbcTemplate.update(
                "update MEMBER set NAME = ?, PASSWORD = ? where ID = ?",
                member.getName(), member.getPassword(), member.getId()
        );
    }


    public int count() {
        Integer count = jdbcTemplate.queryForObject(
                "select count(*) from MEMBER", Integer.class
        );
        return count;
    }
}
