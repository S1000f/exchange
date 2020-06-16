package cointwo.domain.member;

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
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<MemberDto> memRowMapper = new RowMapper<MemberDto>() {
        @Override
        public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            MemberDto member = new MemberDto(
                    rs.getString("ID"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime()
            );
            member.setUid(rs.getLong("UID"));
            return member;
        }
    };

    public MemberDto selectById(String id) {
        List<MemberDto> result = jdbcTemplate.query(
                "select * from MEMBER where ID = ?",
                memRowMapper, id);

        return result.isEmpty() ? null : result.get(0);
    }

    public List<MemberDto> selectByRegdate(LocalDateTime from, LocalDateTime to) {
        List<MemberDto> results = jdbcTemplate.query(
                "select * from MEMBER where REGDATE between ? and ? order by REGDATE desc",
                memRowMapper, from, to);

        return results;
    }

    public List<MemberDto> selectAll() {
        return jdbcTemplate.query(
                "select * from MEMBER",
                memRowMapper);
    }

    public MemberDto selectByUid(Long uid) {
        List<MemberDto> results = jdbcTemplate.query(
                "select * from MEMBER where UID = ?",
                memRowMapper, uid);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(final MemberDto member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection conn)-> {
                    PreparedStatement pstmt = conn.prepareStatement(
                            "insert into MEMBER(ID, PASSWORD, NAME, REGDATE) values(?,?,?,?)",
                            new String[] {"UID"}
                    );
                    pstmt.setString(1, member.getId());
                    pstmt.setString(2, member.getPassword());
                    pstmt.setString(3, member.getName());
                    pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

                    return pstmt;
                }, keyHolder
        );
        Number keyValue = keyHolder.getKey();
        member.setUid(keyValue.longValue());
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
