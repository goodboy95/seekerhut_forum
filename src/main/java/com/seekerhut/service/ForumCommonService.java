package com.seekerhut.service;

import com.seekerhut.mapper.ForumPostDAO;
import com.seekerhut.mapper.ForumReplyDAO;
import com.seekerhut.mapper.ForumSectionDAO;
import com.seekerhut.model.ForumPost;
import com.seekerhut.model.ForumReply;
import com.seekerhut.model.ForumSection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("forumCommonService")
public class ForumCommonService {
    @Resource
    private ForumSectionDAO sectionMapper;
    @Resource
    private ForumPostDAO postMapper;
    @Resource
    private ForumReplyDAO replyMapper;

    public Boolean saveSection(ForumSection section) {
        if (section.getId() != null) {
            sectionMapper.updateByPrimaryKey(section);
        } else {
            sectionMapper.insert(section);
        }
        return true;
    }

    public ForumSection getSection(int id) {
        return sectionMapper.selectByPrimaryKey(id);
    }

    public List<ForumSection> getSectionList(int pageIndex, int pageSize) {
        return sectionMapper.getList((pageIndex - 1) * pageSize, pageSize);
    }

    public Boolean savePost(ForumPost post) {
        if (post.getId() != null) {
            postMapper.updateByPrimaryKeySelective(post);
        } else {
            postMapper.insert(post);
        }
        return true;
    }

    public List<ForumPost> getPostList(Long forumId, int pageIndex, int pageSize) {
        return postMapper.getList(forumId, (pageIndex - 1) * pageSize, pageSize);
    }

    public Boolean saveReply(ForumReply reply) {
        if (reply.getId() != null) {
            replyMapper.updateByPrimaryKey(reply);
        } else {
            replyMapper.insert(reply);
        }
        return true;
    }

    public List<ForumReply> getReplyList(Long postId, int pageIndex, int pageSize) {
        return replyMapper.getList(postId, (pageIndex - 1) * pageSize, pageSize);
    }
}