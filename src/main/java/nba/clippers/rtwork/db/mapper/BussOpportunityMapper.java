package nba.clippers.rtwork.db.mapper;

import java.util.List;
import nba.clippers.rtwork.db.entity.BussOpportunity;
import nba.clippers.rtwork.modelExample.BussOpportunityExample;
import org.apache.ibatis.annotations.Param;

public interface BussOpportunityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    long countByExample(BussOpportunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int deleteByExample(BussOpportunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int insert(BussOpportunity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int insertSelective(BussOpportunity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    List<BussOpportunity> selectByExample(BussOpportunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    BussOpportunity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int updateByExampleSelective(@Param("record") BussOpportunity record, @Param("example") BussOpportunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int updateByExample(@Param("record") BussOpportunity record, @Param("example") BussOpportunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int updateByPrimaryKeySelective(BussOpportunity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buss_opportunity
     *
     * @mbg.generated Thu Aug 08 14:38:39 CST 2024
     */
    int updateByPrimaryKey(BussOpportunity record);
}