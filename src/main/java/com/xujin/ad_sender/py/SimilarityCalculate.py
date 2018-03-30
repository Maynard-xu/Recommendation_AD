# -*- coding:utf-8 -*-
import gensim, sys


def similarity(list1, list2):
    model = gensim.models.Word2Vec.load(
        '/Users/xujin/Desktop/毕业设计/implement_code/ad_sender/src/main/java/com/xujin/ad_sender/py/word2vec.modal')
    return model.n_similarity(list1, list2)


if __name__ == '__main__':
    similar = similarity(eval(sys.argv[1]), eval(sys.argv[2]))
    print(similar)
