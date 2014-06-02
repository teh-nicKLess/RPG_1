/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skills.MagicSkillsAbstract.MagicSkills;

import Skills.MagicSkillsAbstract.Element;
import Skills.MagicSkillsAbstract.MagicSkill;

/**
 *
 * @author Enyone
 */
public class MagicBolt extends MagicSkill {

    private double damage;
    private String elementName;
    private final String NAME = "Magic bullet";
    private final double BASEDAMAGE = 30;

    public MagicBolt(Element e) {
        this.setCooldown(0);
        this.setElement(e);
        this.setSkillIcon(null);
        this.setSkillType("bullet");
        this.setTarget("mouse");
        this.setName(NAME);

        calcDamage();
        this.elementName = e.getName();

        this.setDescription(skillDescription());

    }

    private void calcDamage() {
        this.damage = this.BASEDAMAGE + Utilities.Modifier.getMagicEfficiency();
    }

    private String skillDescription() {
        return "A basic missile spell that deals " + this.damage + " " + this.elementName + " damage";
    }
}
