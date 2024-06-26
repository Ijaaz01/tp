# Jeffinson Darmawan - Project Portfolio Page

## Overview
Florizz is a digital florist replacement that helps users choose appropriate
flowers to put into a bouquet for various occasions. 

### Summary of Contributions 
Code Contribution: [Jeffinson Darmawan RepoSense Report](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=jeffinsondarmawan&breakdown=true)

**New Features:**

1. Fuzzy Logic (Pull Request [#71](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/71), 
[#83](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/83),
[#84](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/84),
[#87](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/87),
[#162](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/162))

    - What it is: 
   
      Theoretically, Fuzzy Logic is a mathematical framework that deals with uncertainty and imprecision in 
      decision-making. Rather than only accepting a binary value of truth (i.e. true or false), Fuzzy Logic allows variables
      to have a degree of truth which gives it the sense of "Fuzziness". Practically, Fuzzy Logic is implemented in 
      the Florizz programme to reduce human error in typing inputs with typos. For example, take a valid command of 
      `info Rose` where Florizz will show information regarding that flower. Suppose that a user mistakenly input
      `invo Ross` and another user mistakenly input `zjgh bfre`. Without Fuzzy Logic, both `invo Ross` and `zjgh bfre` 
      will be regarded as equaly invalid commands and the programme will throw an exception. However, one can make a 
      strong case that `invo Ross` is definitely closer to `info Rose` compared to `zjgh bfre`.
    - Justification:
      Fuzzy Logic helps
      users by correcting their typos due to accidental human errors and increase the overall convenience of using the
      programme. This feature is especially useful for users who are prone to making typos in their inputs. By implementing
       Fuzzy Logic, Florizz is able to correct these typos and provide the user with the intended output thereby reducing 
       the effect of human errors.Imagine having to retype `adds Rose /q 1 /to Bouquet for My 3th Anniversary with My Girlfriend`
       because of a small mistake of having an "s" after "add" and repeating this over and over again!
    - How it works: 

      Fuzzy Logic in Florizz works primarily in 3 ways. Firstly, applying 
      `detectItem(userInput, validCommand)`, Florizz will calculate the Damerau-Levenshtein distance which is a metric 
      used to measure the similarity between the user input and a list of predetermined valid commands. 
      It calculates the minimum number of single-character edits required to change userInput to a valid command,
      by counting the number of insertions, deletions, substitutions and transpositions of individual characters. For
      Florizz, we use a SIMILARITY_THRESHOLD of 2, meaning that we would only match a userInput to a valid command which
      has the smallest distance that is less than 2. example, the userInput: `myboquets` compared to a validCommand: 
      `mybouquets` has a Damerau-Levenshtein distance of one. Secondly, Florizz also recognises inputs which mistakenly 
      have whitespaces separating alphabets which form valid commands. For example, Florriz is able to correct `h e l p`
      into `help` or `re mov e Lily /q 1 /from bouquet`into `remove Lily /q 1 /from bouquet`. Thirdly, Florizz can 
      also correct inputs which are mistakenly glued to each other, such as `flowersmothersday` into `flowers Mothers Day`.

2. Listing Available Occasion (Pull Request [#26](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/26))
   - What it is:
      `occasion` lists out all the occasions which are associated will all flowers in our database. This
      allows users to have a quick look at what occasions they can choose for their flowers. Once users know what occasion 
      they can input `flowers <occasion>` to see all the flowers associated with the occasion of choosing.
   - Justification:
       This feature is especially useful for users who are unsure of what flowers to choose for a specific occasion.
3. Help Command (Pull Request [#16](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/16))
   - What it is:
     `help` assists users in using Florizz by showing a quick list of commands that users can use.
   - Justification:
     This feature is especially useful for new users who are unfamiliar with the commands available in Florizz.
   - Highlights: 
      This feature uses an ASCII table to increase readability of the list of available commands.
4. Compare Command
   - What it is:
      `compare` allows users to compare the colour, occasion, meaning, type and price of two flowers.
   - Justification:
      When deciding which flowers to add to a bouquet, users might find it difficult to compare between different flowers
     as they need to separately call the `info` command for each flower.
       Thus, this feature is especially useful for users who are deciding between two flowers and want to know the 
     differences between them.
   - Highlights:
      This feature required the implementation of a new command and the creation of a new class to handle the comparison of two flowers.
      It also uses an ASCII table to increase readability of the comparison results.

**Enhancements:**
1. Applying appropriate exceptions to ensure valid integer inputs in all commands involving integers 
(Pull Request [#166](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/166)) 
2. Added price information to bouquets (Pull Request [#65](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/65))
3. Improving Parser class by applying FuzzyLogic.detectItem() 
(Pull Request [#71](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/71))
4. Wrote JUnit tests for `AddFlowerCommandTest`, `HelpTest`, `InfoCommandTest`, `ListOccasionCommandTest`, 
   `RemoveFlowerCommandTest`, `FuzzyLogicTest`, `ParserTest`, `CompareCommandTest`
   and wrote additional JUnit tests for `AddBouquetTest`,
   `DeleteBouquetTest` which increases classes coverage from 54% to 63% and lines coverage from 29% to 51%.

**Documentation**
1. Developer Guide
(Pull Request [#82](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/82))
   - Added UML diagrams and implementation details for `remove` and `help`
2. User Guide 
(Pull Request [#106](https://github.com/AY2324S2-CS2113-T11-3/tp/pull/106))
   - Added documentation on `compare` and Fuzzy Logic 
   - Updated documentation on `help`, `new`, `add` and `remove`

**Tools**
1. Integrated a third party JTextUtil library called "freva ascii-table" to create ASCII tables for the `help` 
and `compare` commands. (Link to Github Page: [Freva ASCII Table](https://github.com/freva/ascii-table))