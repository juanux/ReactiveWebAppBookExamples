package services

import javax.inject.Singleton

import models.Vocabulary
import play.api.i18n.Lang

@Singleton
class VocabularyService {

  private var allVocabulary = List(Vocabulary(Lang("en"), Lang("fr"), "hello", "bonjeour"), Vocabulary(Lang("en"), Lang("fr"), "play", "joeur"))

  def addVocabulary(v: Vocabulary): Boolean = {

    if (!allVocabulary.contains(v)) {
      allVocabulary = v :: allVocabulary
      true
    } else {
      false

    }

  }



}
