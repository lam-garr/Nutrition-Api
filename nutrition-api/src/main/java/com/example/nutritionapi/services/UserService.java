package com.example.nutritionapi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.nutritionapi.entity.UserEntity;
import com.example.nutritionapi.models.DiaryEntry;
import com.example.nutritionapi.models.NutritionInfo;
import com.example.nutritionapi.models.User;
import com.example.nutritionapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String EXIST_NAME = "Username";

    public Optional<UserEntity> findByUsername(String username){
        if(!EXIST_NAME.equalsIgnoreCase(username)) return Optional.empty();

        var user = new UserEntity();

        user.setId(123456789);
        user.setUsername(EXIST_NAME);
        user.setPassword(new BCryptPasswordEncoder().encode("password"));
        return Optional.of(user);
    }

    public void deleteUser(String usernameToDelete){
        userRepository.deleteByUsername(usernameToDelete);
    }

    public List<DiaryEntry> getUserDiaryEntries(int id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        final User theUser = mongoTemplate.findOne(query, User.class);

        return theUser.getMyData();
    }

    public void addUser(String username, String password) {
        List<DiaryEntry> myData = new ArrayList<>();
        userRepository.save(new User(UUID.randomUUID().toString(),
            username,
            new BCryptPasswordEncoder().encode(password),
            "First name",
            "Last Name",
            "token",
            myData));
        return;
    }

    public List<DiaryEntry> getUserSortedCollection(String sortCriteria, int id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        final User theUser = mongoTemplate.findOne(query, User.class);

        List<DiaryEntry> sortedList = theUser.getMyData();
        
        if(sortCriteria == "low-high"){
            Collections.sort(sortedList, (i1,i2) -> i1.getCalories() - i2.getCalories());
            return sortedList;
        }else {
            Collections.sort(sortedList, (i1,i2) -> i2.getCalories() - i1.getCalories());
            return sortedList;
        }
    }

    public List<NutritionInfo> getUserSortedDiary(String sortCriteria, String diaryId, int id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        final User theUser = mongoTemplate.findOne(query, User.class);

        DiaryEntry diaryEntry = theUser.getMyData().stream()
            .filter(d -> d.getId().equals(diaryId))
            .findFirst()
            .orElse(null);

        List<NutritionInfo> diary = diaryEntry.getDiary();

        if(sortCriteria == "low-high"){
            Collections.sort(diary, (i1,i2) -> i1.getENERC_KCAL().getQuantity() - i2.getENERC_KCAL().getQuantity());
            return diary;
        }else {
            Collections.sort(diary, (i1,i2) -> i2.getENERC_KCAL().getQuantity() - i1.getENERC_KCAL().getQuantity());
            return diary;
        }
    }

    public void editDiaryDate(String month, int day, int year, String diaryId, int id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        final User theUser = mongoTemplate.findOne(query, User.class);

        DiaryEntry diaryEntry = theUser.getMyData().stream()
            .filter(d -> d.getId().equals(diaryId))
            .findFirst()
            .orElse(null);

        String newDay = Integer.toString(day);
        String newYear = Integer.toString(year);
        diaryEntry.setDay(month + "/" + newDay + "/" + newYear);
        
        return;
    }

    public void deleteSingleEntryFromCollection(String diaryId, int id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        final User theUser = mongoTemplate.findOne(query, User.class);

        String deleteId = "something from params";

        List<DiaryEntry> diaryEntries = theUser.getMyData().stream()
            .filter(d -> !d.getId().contains(deleteId))
            .collect(Collectors.toCollection(ArrayList::new));

        Query secondQuery = new Query();
        secondQuery.addCriteria(Criteria.where("id").is(id).and("myData")
            .elemMatch(Criteria.where("id").is(diaryId)));
            
        return;
    }

    /* public void deleteFromEntry(String diaryId, int id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        final User theUser = mongoTemplate.findOne(query, User.class);
        
        return;
    } */

    public DiaryEntry getUserDiaryEntry(String diaryId, int id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        final User theUser = mongoTemplate.findOne(query, User.class);
        
        DiaryEntry diaryEntry = theUser.getMyData().stream()
            .filter(d -> d.getId().equals(diaryId))
            .findFirst()
            .orElse(null);

        return diaryEntry;
    }

    /* public NutritionInfo getNutritionInfo(String item, int id) {
        return;
    } */
}
