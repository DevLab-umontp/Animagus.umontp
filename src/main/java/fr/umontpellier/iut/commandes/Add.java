package fr.umontpellier.iut.commandes;

import java.security.SecureRandom;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Add
 */
class Add extends ListenerAdapter implements Commande {

    private static final String[] ICONES_ANIMAUX = { "🐵", "🐶", "🐺", "🐱", "🦁", "🐯", "🦒", "🦊", "🦝", "🐮", "🐷", "🐗",
            "🐭", "🐹", "🐰", "🐻", "🐨", "🐼", "🐸", "🦓", "🐴", "🦄", "🐔", "🦧", "🦮", "🐩", "🐕", "🐈", "🐅", "🐆",
            "🐎", "🦌", "🦏", "🦛", "🐂", "🐃", "🐄", "🐖", "🐏", "🐑", "🐐", "🐪", "🐫", "🦙", "🦘", "🦥", "🦨", "🦡",
            "🐘", "🐁", "🐀", "🦔", "🐇", "🐿", "🦎", "🐊", "🐢", "🐍", "🦕", "🦖", "🦦", "🦈", "🐬", "🐳", "🐋", "🐟",
            "🐠", "🐡", "🦐", "🦑", "🐙", "🦞", "🦀", "🦆", "🐓", "🦃", "🦅", "🕊", "🦢", "🦜", "🦩", "🦚", "🦉", "🐦",
            "🐧", "🐥", "🐤", "🦇", "🦋", "🐌", "🐛", "🦟", "🦗", "🐜", "🐝", "🐞", "🦂", "🕷" };

    static String getLien(String messageRecue) {
        String animalChoisi = messageRecue.substring(5).toLowerCase();
        return String.format(
                "Clic sur le lien pour ajouter ton image de %s %s  %s  %s  :%n 📎 https://github.com/DevLab-umontp/Animagus.umontp/issues/new?labels=Ajout+image&title=Ajout+image+de+%s&body=Glisser+votre+image+ici %n N'oublie pas de te connecter avec ton compte GitHub avant",
                animalChoisi, getRandomIcone(), getRandomIcone(), getRandomIcone(), animalChoisi);
    }

    private static String getRandomIcone() {
        return ICONES_ANIMAUX[new SecureRandom().nextInt(ICONES_ANIMAUX.length)];
    }

    @Override
    public void execute(Message messageRecue) {
        messageRecue.getChannel().sendMessage(getLien(messageRecue.getContentRaw())).queue();

    }

}
