class Solution {
      public List<String> removeComments(String[] source) {
            ArrayList<String> result = new ArrayList<>();

            boolean block = false;

            String temp = "";

            for (String line : source) {
                  if (!block) {
                        temp = "";
                  }

                  for (int i = 0; i < line.length(); i++) {
                        if (block) {
                              if (line.charAt(i) == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                                    //when we are inside line comment and finding its endpoint.
                                    block = false;
                                    i++;
                              }
                        } else {
                              if (line.charAt(i) == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                                    // encountered the block comment so just directly break out of this current line and
                                    // check for next line.
                                    break;
                              }

                              if (line.charAt(i) == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                                    /* encountered the line comment and now jump to 1st if condition 
                                    for finding the closing side of line comment*/
                                    block = true;
                                    i++;
                                    continue;
                              }
                              // if didnt encountered any comments just add answer in temp
                              temp += line.charAt(i);

                        }
                  }
                  if (!block) {
                        // add stored temp answer in result. 
                        if (temp.length() > 0) {
                              result.add(temp);
                        }
                  }
            }

            return result;
      }
}