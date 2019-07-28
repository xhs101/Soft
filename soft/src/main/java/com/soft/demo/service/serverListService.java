package com.soft.demo.service;

import com.soft.demo.model.serverlist;
import com.soft.demo.repository.serverListRepository;
import com.soft.demo.web.Dto.ServerDto;
import com.soft.demo.web.exceptions.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
@Slf4j
public class serverListService {

//    private static final Logger log = LoggerFactory.getLogger(serverListService.class);
    private static final Date date = new Date();
    private static final Integer isdelete = 0;

    @Autowired
    private serverListRepository serverListRepositiry;


    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    public serverlist find(Integer id) {
        if (id != null) {
            log.info("id:" + id);
            serverlist allById = serverListRepositiry.findAllById(id);
            if(allById == null){
                throw new DataException();
            }
            return allById;
        } else {
            throw new NullPointerException("参数异常");
        }
    }

    /**
     * 更新或新增操作
     *
     * @param serverDto
     * @return
     */
    public void insert(ServerDto serverDto) {
        serverlist server = new serverlist();
        try {
            Integer id = serverDto.getId();
            String serverUsername = serverDto.getServerUsername();
            String serverUrl = serverDto.getServerUrl();
            Integer port = serverDto.getPort();
            String serverName = serverDto.getServerName();
            String serverPassword = serverDto.getServerPassword();
            String aes = serverDto.getAes();
            Integer isDeleted = serverDto.getIsDeleted();
            if (serverUsername == null || "".equals(serverName) ||
                    port == null || serverName == null || "".equals(serverName) ||
                    serverPassword == null || "".equals(serverPassword) ||
                    aes == null || "".equals(aes)
            ) {
                throw new NullPointerException("参数异常");
            }
            if (id != null) {
                // 根据Id查询
                serverlist allById = serverListRepositiry.findAllById(id);
                log.info("根据Id查询：" + id);
                if (allById != null) {
                    log.info("更新操作");
                    allById.setServerUrl(serverUrl);
                    allById.setServerUsername(serverUsername);
                    allById.setPort(port);
                    allById.setServerName(serverName);
                    allById.setServerPassword(serverPassword);
                    allById.setAes(aes);
                    allById.setIsDeleted(isDeleted);
                    allById.setModifiedTime(date);
                    serverListRepositiry.save(allById);
                } else {
                    log.info("新增操作");
                    server.setServerUrl(serverUrl);
                    server.setServerUsername(serverUsername);
                    server.setPort(port);
                    server.setServerName(serverName);
                    server.setServerPassword(serverPassword);
                    server.setAes(aes);
                    server.setIsDeleted(isDeleted);
                    server.setCreateTime(date);
                    server.setModifiedTime(date);
                    serverListRepositiry.save(server);
                }
            }
        } catch (Exception e) {
            log.info("操作失败！" + e);
            e.printStackTrace();
        }
    }

    /**
     * 根据Id删除
     *
     * @param id
     */
    public void delete(Integer id) {
        try {
            serverlist allById = serverListRepositiry.findAllById(id);
            if (allById == null) {
                throw new DataException();
            } else {
                log.info("删除Id：" + id + "是否有效：" + isdelete);
                allById.setIsDeleted(isdelete);
                allById.setModifiedTime(date);
                serverListRepositiry.save(allById);
            }
        } catch (Exception e) {
            log.info("异常" + e);
            e.printStackTrace();
        }
    }
}
