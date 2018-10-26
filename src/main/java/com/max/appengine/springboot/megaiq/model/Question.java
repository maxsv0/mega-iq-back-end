/*
 * Copyright 2018 mega-iq.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.max.appengine.springboot.megaiq.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.max.appengine.springboot.megaiq.model.entity.EntityQuestion;
import com.max.appengine.springboot.megaiq.model.enums.IqQuestionGroup;
import com.max.appengine.springboot.megaiq.model.enums.Locale;
import com.max.appengine.springboot.megaiq.service.QuestionsService;

public class Question extends EntityQuestion {

  private List<Answer> answers;
  
  public List<Answer> getAnswers() {
    return answers;
  }
  private QuestionsService serviceQuestion;
  
  public Question(EntityQuestion question) {
	super();

    this.setId(question.getId());
    this.setPic(question.getPic());
    this.setPoints(question.getPoints());
    this.setAnswerCorrect(question.getAnswerCorrect());
    this.setTitle(question.getTitle());
    this.setDescription(question.getDescription());
    this.setGroups(question.getGroups());
    this.setCreateDate(question.getCreateDate());
    this.setUpdateDate(question.getUpdateDate());
    this.setLocale(question.getLocale());
    
    this.answers = serviceQuestion.getAnswersByQuestionId(question.getId(), question.getLocale());
  }

  public Question(Integer id, String pic, Integer points, Integer answerCorrect, String title,
      String description, ArrayList<IqQuestionGroup> groups, Date createDate, Date updateDate,
      Locale locale) {
    super();
    
    this.setId(id);
    this.setPic(pic);
    this.setPoints(points);
    this.setAnswerCorrect(answerCorrect);
    this.setTitle(title);
    this.setDescription(description);
    this.setGroups(groups);
    this.setCreateDate(createDate);
    this.setUpdateDate(updateDate);
    this.setLocale(locale);
    
    this.answers = serviceQuestion.getAnswersByQuestionId(id, locale);
  }
}
