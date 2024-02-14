package com.mobatia.nasmanila.activities.cca.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by RIJO K JOSE on 25/1/17.
 */
public class CCADetailModel implements Serializable {

    String day;
    String choicee1;
    String choicee2;
    ArrayList<CCAchoiceModel> choice1;
    String choice1Id;
    String choice2Id;
    String cca_item_start_timechoice1;
    String cca_item_end_timechoice1;
    String cca_item_start_timechoice2;
    String cca_item_end_timechoice2;
    String cca_item_description;
    String venue;

    public String getCca_item_description() {
        return cca_item_description;
    }

    public void setCca_item_description(String cca_item_description) {
        this.cca_item_description = cca_item_description;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public ArrayList<CCAchoiceModel> getCcaChoiceModel2() {
        return choice2;
    }

    public void setCcaChoiceModel2(ArrayList<CCAchoiceModel> ccaChoiceModel2) {
        this.choice2 = ccaChoiceModel2;
    }

    ArrayList<CCAchoiceModel> choice2;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<CCAchoiceModel> getCcaChoiceModel() {
        return choice1;
    }

    public void setCcaChoiceModel(ArrayList<CCAchoiceModel> ccaChoiceModel) {
        this.choice1 = ccaChoiceModel;
    }

    public String getChoice1() {
        return choicee1;
    }

    public void setChoice1(String choice1) {
        this.choicee1 = choice1;
    }

    public String getChoice2() {
        return choicee2;
    }

    public void setChoice2(String choice2) {
        this.choicee2 = choice2;
    }

    public String getChoice1Id() {
        return choice1Id;
    }

    public void setChoice1Id(String choice1Id) {
        this.choice1Id = choice1Id;
    }

    public String getChoice2Id() {
        return choice2Id;
    }

    public void setChoice2Id(String choice2Id) {
        this.choice2Id = choice2Id;
    }

    public String getCca_item_start_timechoice1() {
        return cca_item_start_timechoice1;
    }

    public void setCca_item_start_timechoice1(String cca_item_start_timechoice1) {
        this.cca_item_start_timechoice1 = cca_item_start_timechoice1;
    }

    public String getCca_item_end_timechoice1() {
        return cca_item_end_timechoice1;
    }

    public void setCca_item_end_timechoice1(String cca_item_end_timechoice1) {
        this.cca_item_end_timechoice1 = cca_item_end_timechoice1;
    }

    public String getCca_item_start_timechoice2() {
        return cca_item_start_timechoice2;
    }

    public void setCca_item_start_timechoice2(String cca_item_start_timechoice2) {
        this.cca_item_start_timechoice2 = cca_item_start_timechoice2;
    }

    public String getCca_item_end_timechoice2() {
        return cca_item_end_timechoice2;
    }

    public void setCca_item_end_timechoice2(String cca_item_end_timechoice2) {
        this.cca_item_end_timechoice2 = cca_item_end_timechoice2;
    }
}
