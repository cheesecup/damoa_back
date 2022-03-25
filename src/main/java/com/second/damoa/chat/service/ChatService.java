package com.second.damoa.chat.service;

import com.second.damoa.chat.model.Chat;
import com.second.damoa.chat.repository.ChatRepository;
import com.second.damoa.chat.repository.ChatUserInterface;
import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import com.second.damoa.social.model.User;
import com.second.damoa.social.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final GroupInfoRepository groupInfoRepository;

    /* CREATE */
    @Transactional
    public String chatSave(String name, Long id, String comment) {
        User user = userRepository.findByName(name);
        GroupInfo groupInfo = groupInfoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));
        Chat chat1 = new Chat();
        chat1.setUser(user);
        chat1.setGroupInfo(groupInfo);
        chat1.setComment(comment);

        chatRepository.save(chat1);
        return ""; }

    /* 조회 */
    @Transactional
    public List<ChatUserInterface> chatList(Long id) {
        List<ChatUserInterface> ChatList = chatRepository.ChatList(id);
        return ChatList;
    }


}

