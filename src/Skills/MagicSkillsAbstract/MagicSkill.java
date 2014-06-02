/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skills.MagicSkillsAbstract;

import Skills.Skill;
import Utilities.Modifier;

/**
 *
 * @author Enyone
 */
public abstract class MagicSkill extends Skill {

    private Element element;
    private String skillType;
    private double efficiency;

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
    
    public double getEfficiency() {
        return Modifier.getMagicEfficiency();
    }
    
}
