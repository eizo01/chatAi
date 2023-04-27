package cn.zdw.chatbot.api.domain.zsxq;



import cn.zdw.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @description 知识星球 API 接口
 */
public interface IZsxqApi {
    /**
     *  未回答问题的集合
     * @param groupId https://api.zsxq.com/v2/groups/15552585485252
     * @param cookie
     * @return
     * @throws IOException
     */
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    /**
     *
     * @param groupId
     * @param cookie
     * @param topicId 回答问题id
     * @param text 文本
     * @param silenced 是否对星球可见
     * @return
     * @throws IOException
     */
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;

}