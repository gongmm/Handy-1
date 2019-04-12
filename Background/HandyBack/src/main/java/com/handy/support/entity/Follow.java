package com.handy.support.entity;

public class Follow {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.follow_id
     *
     * @mbggenerated
     */
    private Integer followId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.follower_id
     *
     * @mbggenerated
     */
    private Integer followerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow
     *
     * @mbggenerated
     */
    public Follow(Integer followId, Integer userId, Integer followerId) {
        this.followId = followId;
        this.userId = userId;
        this.followerId = followerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.follow_id
     *
     * @return the value of follow.follow_id
     *
     * @mbggenerated
     */
    public Integer getFollowId() {
        return followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.user_id
     *
     * @return the value of follow.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.follower_id
     *
     * @return the value of follow.follower_id
     *
     * @mbggenerated
     */
    public Integer getFollowerId() {
        return followerId;
    }
}