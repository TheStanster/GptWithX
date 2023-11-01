package dnd

import com.xebia.functional.xef.conversation.llm.openai.OpenAI
import com.xebia.functional.xef.conversation.llm.openai.prompt
import kotlinx.serialization.Serializable

@Serializable
data class DndNpc(
    val name: String,
    val race: String,
    val gender: String,
    val age: String,
    val size: String,
    val type: String,
    val alignment: String,
    val characterClass: String,
    val abilities: Abilities,
    val skills: String,
    val equipment: String,
    val backstory: String,
    val appearance: Appearance,
    val personalityTraits: PersonalityTraits,
)

@Serializable
data class Abilities(
    val strength: String,
    val dexterity: String,
    val constitution: String,
    val intelligence: String,
    val wisdom: String,
    val charisma: String
)

@Serializable
data class Appearance(
    val heightInCm: String,
    val weightInKg: String,
    val eyes: String,
    val skin: String,
    val hair: String,
    val physique: String,
    val description: String
)

@Serializable
data class PersonalityTraits(
    val quirks: String,
    val likes: String,
    val dislikes: String,
    val fears: String,
//    val aspirations: String
)

suspend fun main() =
  OpenAI.conversation {
    val npc: DndNpc = prompt("Create a unique new compelling dnd npc character.")
    println(
        """|New Dungeons & Dragons NPC created:
           |Name: ${npc.name}
           |Race: ${npc.race}
           |Gender: ${npc.gender}
           |Age: ${npc.age}
           |Size: ${npc.size}
           |Type: ${npc.type}
           |Alignment: ${npc.alignment}
           |Character Class: ${npc.characterClass}
           |Abilities:
           |  - Strength: ${npc.abilities.strength}
           |  - Dexterity: ${npc.abilities.dexterity}
           |  - Constitution: ${npc.abilities.constitution}
           |  - Intelligence: ${npc.abilities.intelligence}
           |  - Wisdom: ${npc.abilities.wisdom}
           |  - Charisma: ${npc.abilities.charisma}
           |Skills: ${npc.skills}
           |Equipment: ${npc.equipment}
           |Backstory: ${npc.backstory}
           |Appearance:
           |  - Height: ${npc.appearance.heightInCm} cm
           |  - Weight: ${npc.appearance.weightInKg} kg
           |  - Eyes: ${npc.appearance.eyes}
           |  - Skin: ${npc.appearance.skin}
           |  - Hair: ${npc.appearance.hair}
           |  - Physique: ${npc.appearance.physique}
           |  - Description: ${npc.appearance.description}
           |Personality Traits:
           |  - Quirks: ${npc.personalityTraits.quirks}
           |  - Likes: ${npc.personalityTraits.likes}
           |  - Dislikes: ${npc.personalityTraits.dislikes}
           |  - Fears: ${npc.personalityTraits.fears}
        """.trimMargin()
    )
  }
