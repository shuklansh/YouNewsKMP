//
//  ArticleScreen.swift
//  iosApp
//
//  Created by Ansh Shukla on 01/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticleScreen {
    
    @MainActor
    class ArticleViewModelWrapper: ObservedObject {
        let articlesViewModel: ArticlesViewModel
        
        init() {
            articlesViewModel = ArticlesViewModel()
            articleState = articlesViewModel.articleState.value
        }
        
        @Published var articleState: ArticleState
        
        func startObserving() {
            Task {
                for await articleS in articlesViewModel.articleState {
                    self.articleState = articleS
                }
            }
        }
    }
}

struct ArticleScreen: View {
    @ObservedObject private (set) var vm: ArticleViewModelWrapper
    var body: some View {
        VStack {
            if vm.articleState.error {
                Text("Error")
            }
            if vm.articleState.loading {
                Loader()
            }
            if (!vm.articleState.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        forEach(vm.articleState.articles, id: \.self) { article in
                            Text(article.title)
                            Text(article.content)
                            Text(article.author)
                        }
                    }
                }
            }
        }.onAppear{
            self.vm.startObserving()
        }
    }
}

//#Preview {
//    ArticleScreen()
//}
