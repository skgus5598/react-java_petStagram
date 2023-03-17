package com.project.petstagram.user.userRepo;

import com.project.petstagram.user.userDto.UserRequest;
import com.project.petstagram.user.userEntity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUserId(String userId);
    public void deleteByUserId(String userId);

 /*   @Transactional
    @Modifying(clearAutomatically = true) // clear~옵션을 주게 되면 업데이트 쿼리를 날린 후 영속성 컨테스트를 자동으로 clean해줌
    @Query( value= "UPDATE PET_USER  SET USER_INTRO = :userIntro WHERE USER_ID = :userId ",nativeQuery = true)
    public int updateUser(@Param("userIntro") String userIntro, @Param("userId") String userId);
*/
}

